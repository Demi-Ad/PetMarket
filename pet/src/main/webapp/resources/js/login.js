window.onload = () => {
    const message = window.location.search.split("=")[1];
    if (message === undefined || message === null)
        return

    const s = decodeURI(message).replaceAll("+"," ");
    alert(s)
}