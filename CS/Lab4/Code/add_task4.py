def xml_to_array(name):
    file = open(name)
    file.readline()
    separator = 'Death Grips is online'
    separated = file.read().replace('\n', ' ').replace('\t', '')
    separated = separated.replace('> <', '>' + separator + '<').replace('><', '>' + separator + '<')
    return separated.split(separator)


def separate(data):
    separator = 'Death Grips is online'
    return data.replace('>', '<').replace('<', '>' + separator + '<').split(separator)[1:-1]


def get_tag(data):
    return separate(data)[0]


def just_tag(data):
    tag = separate(data)[0]
    return tag.replace('<', '').replace('>', '')


def get_value(data):
    if len(separate(data)) > 1:
        return separate(data)[1].replace('<', '').replace('>', '')
    return 0


# parsing process
tsv_file = open('in-out/tsv/timetable.tsv', 'w')
xml_array = xml_to_array('in-out/xml/timetable.xml')

# converting to tsv
for i in range(len(xml_array) - 1):
    if get_value(xml_array[i]):
        tsv_file.write(just_tag(xml_array[i]) + ('\t' if get_value(xml_array[i + 1]) else '\n'))
        if not get_value(xml_array[i + 1]):
            break
for i in range(len(xml_array) - 1):
    if get_value(xml_array[i]):
        tsv_file.write(get_value(xml_array[i]) + ('\t' if get_value(xml_array[i + 1]) else '\n'))

# result representation
tsv_file.close()
result = open('in-out/tsv/timetable.tsv')
print(result.read())
