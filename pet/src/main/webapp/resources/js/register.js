const submitBtn = document.querySelector("#submitBtn");

const state = {
    userIdValidation: false,
    userEmailValidation: false,
}


const proxy = new Proxy(state, {
    set: function (target, name, value) {
        target[name] = value
        for (const valid in target) {
            if (!target[valid]) return
        }
        submitBtn.disabled = false
    }
})

function fetchHandler(evt, type) {
    const inputElem = evt.target.previousElementSibling
    const id = inputElem.value
    const className = evt.target.className
    const innerHtml = evt.target.innerHTML
    evt.target.disabled = true
    evt.target.innerHTML = `
        <div class="spinner-border text-success" style="width: 15px;height: 15px" role="status">
            <span class="visually-hidden">Loading...</span>
        </div>`

    fetch(`/duplicateCheck/${type}?value=${id}`)
        .then(res => res.json())
        .then(result => {
            if (result.isAspect) {

                if (type === 'id') proxy.userIdValidation = true
                else proxy.userEmailValidation = true

                inputElem.disabled = true
                evt.target.innerHTML = `<i class="bi bi-check" style="width: 10px;height: 10px"></i>`
                evt.target.className = className.replace("secondary", "success")
            } else {
                alert(result.message)
                evt.target.className = className
                evt.target.innerHTML = innerHtml
                evt.target.disabled = false
            }
        })
}


document.querySelector("#checkId")
    .addEventListener("click", evt => fetchHandler(evt, "id"))

document.querySelector("#emailCheck")
    .addEventListener("click", evt => fetchHandler(evt, "email"))

submitBtn.addEventListener("click", evt => {
    evt.preventDefault()
    const passwordElem = document.querySelector("#password")
    const passwordCheckElem = document.querySelector("#passwordCheck")

    if (passwordElem.value.length >= 3 && passwordElem.value.length <= 20) {
        if (passwordElem.value === passwordCheckElem.value) {
            document.querySelector("#id").disabled = false
            document.querySelector("#email").disabled = false
            document.forms["form"].submit();
        }
    } else {
        alert("비밀번호는 3글자 이상 20글자 이하여야 합니다")
    }
})