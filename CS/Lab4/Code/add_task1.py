import xmltodict
import json


xml_file = open('in-out/xml/timetable.xml')
json_file = open('in-out/json/timetable_add1.json', 'w')

# parsing process
timetable = xmltodict.parse(xml_file.read())

# converting to json
json_str = json.dumps(timetable)
json_file.write(json_str)

# result representation
json_file.close()
result = open('in-out/json/timetable_add1.json')
print(result.read())
