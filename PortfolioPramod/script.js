// =========================
// Smooth Scroll
// =========================

document.querySelectorAll('nav a').forEach(anchor => {
    anchor.addEventListener('click', function(e) {
        e.preventDefault();

        document.querySelector(this.getAttribute('href')).scrollIntoView({
            behavior: 'smooth'
        });
    });
});


// =========================
// Scroll To Top Button
// =========================

const topBtn = document.createElement("button");
topBtn.innerHTML = "↑";
topBtn.id = "topBtn";
document.body.appendChild(topBtn);

window.addEventListener("scroll", function () {

    if (window.scrollY > 300) {

        topBtn.style.display = "block";

    } else {

        topBtn.style.display = "none";

    }

});

topBtn.onclick = function () {

    window.scrollTo({

        top: 0,

        behavior: "smooth"

    });

};


// =========================
// Hero Typing Animation
// =========================

const text = "Aspiring Java Full Stack Developer";

const typing = document.querySelector(".hero-content h3");

let i = 0;

typing.innerHTML = "";

function typeEffect(){

    if(i < text.length){

        typing.innerHTML += text.charAt(i);

        i++;

        setTimeout(typeEffect,100);

    }

}

typeEffect();


// =========================
// Fade Animation
// =========================

const observer = new IntersectionObserver(entries=>{

entries.forEach(entry=>{

if(entry.isIntersecting){

entry.target.classList.add("show");

}

});

});

document.querySelectorAll("section").forEach(sec=>{

observer.observe(sec);

});

function openTypingProject(){
    document.getElementById("typingModal").style.display="block";
}

function closeTypingProject(){
    document.getElementById("typingModal").style.display="none";
}
function openHygieneGallery() {
    document.getElementById("hygieneGallery").style.display = "flex";
}

function closeHygieneGallery() {
    document.getElementById("hygieneGallery").style.display = "none";
}

function openHygieneProject() {
    document.getElementById("hygieneModal").style.display = "block";
}

function closeHygieneProject() {
    document.getElementById("hygieneModal").style.display = "none";
}

function openTremorProject() {
    document.getElementById("tremorModal").style.display = "block";
}

function closeTremorProject() {
    document.getElementById("tremorModal").style.display = "none";
}

//================== CERTIFICATE ===================

function openCertificate(src){
    document.getElementById("certificateImage").src = src;
    document.getElementById("certificateModal").style.display = "flex";

}

function closeCertificate(){

    document.getElementById("certificateModal").style.display="none";
    document.body.style.overflow = "visible";


}

window.addEventListener("click",function(e){

let modal=document.getElementById("certificateModal");

if(e.target==modal){

modal.style.display="none";

}

});

function goToCertificates() {
    document.getElementById("certificates").scrollIntoView({
        behavior: "smooth",
        block: "start"
    });
}