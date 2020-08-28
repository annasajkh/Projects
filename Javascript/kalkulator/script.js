const hasil = document.querySelector('.kepala');
let h = ''
let hitung = false

function cli(a){
    if(a == '='){
    	h = String(eval(h))
    }else if(a == 'ac'){
    	h = ''
    }else if(a =='<='){
		h = h.slice(0,h.length-1)
    }else{
		if(h.length < 10){
			h+=a
		}
    }
}

setInterval(()=>{
    hasil.innerHTML = h
})