// Wrap every letter in a span
var textWrapper = document.querySelector('.ml12');
textWrapper.innerHTML = textWrapper.textContent.replace(/\S/g, "<span class='letter'>$&</span>");

anime.timeline({loop: false})
  .add({
    
    targets: '.ml12 .letter',
    opacity: [0,1],
    translateX: [40,0],
    translateZ: 0,
    easing: "easeOutExpo",
    duration: 1200,
    delay: (el, i) => 500 + 30 * i
  })
;

// Wrap every letter in a span
var textWrapper2 = document.querySelector('.ml13');
textWrapper2.innerHTML = textWrapper2.textContent.replace(/\S/g, "<span class='letter'>$&</span>");

anime.timeline({loop: false})
  .add({
    
    targets: '.ml13 .letter',
    opacity: [0,1],
    translateX: [40,0],
    translateZ: 0,
    easing: "easeOutExpo",
    duration: 1200,
    delay: (el, i) => 1200 +500 + 30 * i
  })
;