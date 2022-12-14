import xmltodict
import json
import time


start_time = time.time()

for loop in range(100):
    xml_file = open('in-out/xml/timetable.xml')
    json_file = open('in-out/json/timetable_add1.json', 'w')

    # parsing process
    timetable = xmltodict.parse(xml_file.read())

    # converting to json
    json_str = json.dumps(timetable)[::-1]
    json_str = json_str.replace('}', '', 1)
    json_str = json_str[::-1]
    root = json_str.split()[0] + ' '
    json_str = json_str.replace(root, '', 1)
    json_file.write(json_str)

end_time = time.time()

total_time = end_time - start_time
print('Время работы программы: ', "%.3f" % total_time)
