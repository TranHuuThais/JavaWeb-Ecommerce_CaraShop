const bar = document.getElementById('bar');
const close = document.getElementById('close');
const nav = document.getElementsById('navbar');

if (bar) {
    bar.addEventListener('click', () => {
        nav.classList.add('active');
    })
}

if (close) {
    close.addEventListener('click', () => {
        nav.classList.remove('active');
    })
}

function handleEnter(event) {
    if (event.key === "Enter") {
        event.preventDefault(); // Ngăn không cho form submit nhiều lần
        document.querySelector('.form-search').submit(); // Tự động submit form
    }
}

function searchFunction(event) {
    event.preventDefault(); // Ngăn chặn submit mặc định để có thể xử lý tìm kiếm
    // Thực hiện chức năng tìm kiếm của bạn tại đây
    console.log("Searching...");
}