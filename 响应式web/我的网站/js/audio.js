// 播放
play.onclick = function(){
	if(audio.paused){
		audio.play();
	}
}
 
// 暂停
pause.onclick = function(){
	if(audio.played){
		audio.pause();
	}
}

// 自动切换下一首

audio.addEventListener('ended',function(){
	next.onclick();
},false);



// 上一首
prev.onclick = function(){
	num = (num + len - 1) % len;
	audio.src = './music/' + music[num] + '.mp3';
	musicName.innerHTML = music[num];
	bgImage.style.backgroundImage = 'url(./img/' + music[num] + '.jpg)';
	musicImg.src = './img/' + music[num] + '.jpg';
	audio.play();
}
 
// 下一首
next.onclick = function(){
	num = (num + 1) % len;
	audio.src = './music/' + music[num] + '.mp3';
	musicName.innerHTML = music[num];
	bgImage.style.backgroundImage = 'url(./img/' + music[num] + '.jpg)';
	musicImg.src = './img/' + music[num] + '.jpg';
	audio.play();
}
