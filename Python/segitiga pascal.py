inp = int(input("tinggi :"))
arr = []
s = inp

def ke_string(a):
    s = ''
    for i in a:
        s+=str(i)+' '
    return s

for tempat in range(0,inp):
    arr.append([])
    for isi in range(0,tempat+1):
        if tempat < 2:
            arr[tempat].append(1)

for i in range(1,inp-1):
    arr[i+1].append(1)
    for j in range(0,len(arr[i])-1):
       arr[i+1].append(arr[i][j]+arr[i][j+1])
    arr[i+1].append(1)

for i in arr:
    print(' '*inp+ke_string(i))
    inp-=1
    
