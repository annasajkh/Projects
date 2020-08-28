dim suara,mik,jenis
suara = inputBox("Masukan Kata")
jenis = inputBox("Masukan jenis suara (l/p)")
Set mik= createObject("sapi.spvoice")
mik.volume = 100
if jenis = "l" then
	Set mik.voice = mik.getvoices.item(0)
elseIf jenis = "p" then
	Set mik.voice = mik.getvoices.item(1)
end if
mik.speak suara
