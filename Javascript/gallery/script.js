const kecil = document.querySelector('.container');
const besar = document.querySelector('.besar');
const t = document.querySelectorAll('.t');
kecil.addEventListener('click', function(e){
	if(e.target.className == 't'){
	   besar.src = e.target.src;
	   besar.classList.add('fade');
	   setTimeout(function(){
         besar.classList.remove('fade');
	   }, 500);
	   t.forEach(function(t){
	   	t.className = 't';
	   })
	   e.target.classList.add('active');
	}
})