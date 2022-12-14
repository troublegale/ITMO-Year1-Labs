import re


def xml_to_array(name):
    file = open(name)
    file.readline()
    separator = 'Death Grips is online'
    separated = file.read().replace('\n', ' ').replace('\t', '')
    separated = separated.replace('> <', '>' + separator + '<').replace('><', '>' + separator + '<')
    return separated.split(separator)


def get_tag(data):
    tag = re.search(r'</*\w+>', data)[0]
    return tag


def just_tag(data):
    only_tag = get_tag(data)
    return only_tag.replace('<', '').replace('>', '')


def get_value(data):
    info = re.findall(r'[^<>\t]+', data)
    if len(info) == 3:
        return info[1]
    else:
        return 0


def find_array_tags(arr):
    array_tags = []
    for i in arr:
        if i == get_tag(i) and arr.count(get_tag(i)) > 1 and just_tag(i) not in array_tags:
            array_tags.append(just_tag(i))
    return array_tags


# parsing process
json_file = open('in-out/json/timetable_str.json', 'w')
xml_array = xml_to_array('in-out/xml/timetable.xml')
array_tags = find_array_tags(xml_array)

in_arr = False

for i in range(len(xml_array)):

    if i == 0:
        json_file.write('{')
    elif i == len(xml_array) - 1:
        json_file.write('}')
    else:

        data = xml_array[i]
        next_data = xml_array[i + 1]
        tag = get_tag(data)
        only_tag = just_tag(data)
        next_only_tag = just_tag(next_data)
        value = get_value(data)

        if only_tag in array_tags and not in_arr:
            json_file.write('"' + only_tag + '": [')
            in_arr = True

        if in_arr:
            if data == get_tag(data) and '/' not in data:
                json_file.write('{')
            if '/' in only_tag:
                if '/' + next_only_tag == only_tag:
                    json_file.write(', ')
                else:
                    json_file.write(']')
                    in_arr = False
            elif value:
                json_file.write('"' + only_tag + '": "' + value + ('", ' if next_only_tag not in array_tags else '"}'))
        else:
            if '/' not in data:
                json_file.write('"' + only_tag + '": {')
            else:
                json_file.write('}')


# result representation
json_file.close()
result = open('in-out/json/timetable_str.json')
print(result.read())
