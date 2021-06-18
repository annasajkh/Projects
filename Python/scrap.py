import requests
from bs4 import BeautifulSoup

niko_dialog = ""

request = requests.get("https://hunternet93.github.io/OneShot-Dialog-Transcript/dialog.html")

soup = BeautifulSoup(request.content, "html5lib")

dialog = soup.find_all("div", attrs = {"class":"command command-text"}) 

for d in dialog:
	niko_dialog += d.find_all("p")[1].get_text().strip() + '\n\n'

file = open("niko_dialog.txt", "w")
file.write(niko_dialog)
file.close()



