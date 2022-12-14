def input_xml(name):
    file = open(name)
    file.readline()
    return file.read()


def get_tag(line):
    if line:
        line = line.replace('<', ' ').replace('>', ' ').replace('/', ' ')
        tag = line.split()[0]
        return tag


def kind_of_tag(line):
    if line:
        if line.count(get_tag(line)) == 1:
            return '/' in line
        return 2


def tab_count(line):
    if line:
        count = 0
        for i in line:
            if i == '\t':
                count += 1
            else:
                break
        return count


def find_array_tags(timetable):
    array_tags = []
    for i in timetable.split('\n'):
        if i:
            if kind_of_tag(i) == 0 and timetable.count(get_tag(i)) > 2 and array_tags.count(get_tag(i)) == 0:
                array_tags.append(get_tag(i))
    return array_tags


def get_value(line):
    if line:
        tag = get_tag(line).replace('/', '')
        line = line.replace('<', '').replace('>', '').replace('/', '')
        if line:
            return line.split(tag)[1]
        else:
            return 0


class XMLString:
    def __init__(self, tag, kot, value, tabcount):
        self.tag = tag
        self.kot = kot
        self.value = value
        self.tabcount = tabcount


def formalize(timetable):
    xml_strings = []
    for i in timetable.split('\n'):
        if get_tag(i):
            xml_strings.append(XMLString(get_tag(i), kind_of_tag(i), get_value(i), tab_count(i)))
    return xml_strings, find_array_tags(timetable)


json_file = open('in-out/json/timetable_nice.json', 'w')
xml_file = input_xml('in-out/xml/timetable.xml')
xml_strings, array_tags = formalize(xml_file)
currently_in_array = False

for i in range(len(xml_strings)):

    if xml_strings[i].tag in array_tags and not currently_in_array:
        json_file.write('\t' * xml_strings[i].tabcount + '"' + xml_strings[i].tag + '": [\n')
        currently_in_array = True

    if currently_in_array:
        if xml_strings[i].tag in array_tags and int(xml_strings[i].kot) == 1:
            if xml_strings[i].tabcount == xml_strings[i + 1].tabcount:
                json_file.write('\t' * (xml_strings[i].tabcount + 1) + '},\n')
            else:
                json_file.write('\t' * (xml_strings[i].tabcount + 1) + '}\n')
                json_file.write('\t' * xml_strings[i].tabcount + ']\n')
                currently_in_array = False
                array_tags.remove(xml_strings[i].tag)
        elif xml_strings[i].tag in array_tags:
            json_file.write('\t' * (xml_strings[i].tabcount + 1) + '{\n')
        elif xml_strings[i].tabcount == xml_strings[i + 1].tabcount:
            json_file.write('\t' * (xml_strings[i].tabcount + 1) + '"' + xml_strings[i].tag + '": "' + xml_strings[i].value + '",\n')
        else:
            json_file.write('\t' * (xml_strings[i].tabcount + 1) + '"' + xml_strings[i].tag + '": "' + xml_strings[i].value + '"\n')
    elif xml_strings[i].tabcount == 0:
        json_file.write('{\n' if not xml_strings[i].kot else '}\n')
    else:
        if not xml_strings[i].kot:
            json_file.write('\t' * xml_strings[i].tabcount + '"' + xml_strings[i].tag + '": {\n')
        else:
            json_file.write('\t' * xml_strings[i].tabcount + '}\n')

json_file.close()
result = open('in-out/json/timetable_nice.json')
print(result.read())
