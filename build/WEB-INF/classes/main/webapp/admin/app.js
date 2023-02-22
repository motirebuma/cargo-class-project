const viewMore = document.querySelector('.view-more')
const viewMores = document.querySelector('.view-mores')
let opened = true

viewMore.addEventListener('click', () => {
    if(opened) {
        viewMores.classList.remove('hidden')
        viewMore.innerHTML = "View Less"
    }else{
        viewMores.classList.add('hidden')
        viewMore.innerHTML = "View More"

    }
    opened = !opened
    console.log("heloooooooooooooo")
})
