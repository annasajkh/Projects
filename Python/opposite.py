

letters = "abcdefghijklmnopqrstuvwxyz"


thing = input("> ")

result = ""

for t in thing:
    if t.isalpha():
        if t.isupper():
            result += letters[-letters.index(t.lower()) - 1].upper()
        else:
            result += letters[-letters.index(t) - 1]
    else:
        result += t
print(result)
