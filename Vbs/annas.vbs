set wshshell = wscript.createobject("WScript.Shell")
for var = 0 to 50
wshshell.run "notepad"
wscript.sleep 100
wshshell.sendkeys "a"
wscript.sleep 100
wshshell.sendkeys "n"
wscript.sleep 100
wshshell.sendkeys "n"
wscript.sleep 100
wshshell.sendkeys "a"
wscript.sleep 100
wshshell.sendkeys "s"
wscript.sleep 100
wshshell.sendkeys " "
wscript.sleep 100
wshshell.sendkeys "g"
wscript.sleep 100
wshshell.sendkeys "a"
wscript.sleep 100
wshshell.sendkeys "n"
wscript.sleep 100
wshshell.sendkeys "t"
wscript.sleep 100
wshshell.sendkeys "e"
wscript.sleep 100
wshshell.sendkeys "n"
wscript.sleep 100
wshshell.sendkeys "g"
next