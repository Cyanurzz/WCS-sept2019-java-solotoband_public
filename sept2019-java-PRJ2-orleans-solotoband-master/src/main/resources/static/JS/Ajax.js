window.onload = function () {

	if (myError === "1") {
		$("#exampleModalCenter").modal()
		let myModal = document.getElementById("PasswordInput");
		let myPara = document.createElement('p')
		myPara.textContent ="Oups, login ou mot de passe incorrect";
		myPara.style.color = "red";
		myModal.appendChild(myPara);
	}
};