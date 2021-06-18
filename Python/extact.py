import re

text = ""
niko_dialog = []

file = open("input.txt","r")

for line in file.readlines():
	text += line + '\n'
file.close()

data_face = re.findall(".*?:",text)

data_dialog = re.split(".*?:",text)
data_dialog.pop(0)

for i in range(len(data_face)):
	if "niko" in data_face[i]:
		niko_dialog.append(data_dialog[i])

for i in niko_dialog:
	print(i)