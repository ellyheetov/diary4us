const getHTML = (url) => {
  fetch(url).then((resolve) => {
    return resolve.json();
  }).catch((error) => {
    console.log(error);
  })
}

const insertHTML = (url, target) => {
  const base = document.querySelector('.' + target);
  const page = getHTML(url);

  base.appendChild(page);

}