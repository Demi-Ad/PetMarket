document.querySelector("#findEmailBtn").addEventListener("click",evt => {
        const inputElem = evt.target.previousElementSibling;
        const innerHTML = evt.target.innerHTML;
        evt.target.innerHTML = `
            <div class="spinner-border text-success" style="width: 15px;height: 15px" role="status">
                <span class="visually-hidden">Loading...</span>
            </div>`
        evt.target.disabled = true

        const email = inputElem.value;

        fetch(`/forgot/id?email=${email}`)
            .then(res => {
                if (res.status === 400) {
                    throw new Error("존재하지 않는 회원입니다")
                } else {
                    return res.json()
                }
            })
            .then(data => {
                document.querySelector("#idResult").innerHTML = `<p>가입하신 아이디는 ${data.result} 입니다</p>`

            })
            .catch(err => {
                document.querySelector("#idResult").innerHTML = `<p>${err.message}</p>`
            }).finally(() => {
            evt.target.innerHTML = innerHTML
            evt.target.disabled = false
        })
    })

document.querySelector("#passwordBtn").addEventListener("click",evt => {
    const accountId = document.querySelector("#idInput").value;
    const questions = document.querySelector("#questions").value;
    const answer = document.querySelector("#answer").value;

    if (accountId && questions && answer) {
        evt.target.disabled = true
        const innerHtml = evt.target.innerHTML
        evt.target.innerHTML = `
            <div class="spinner-border text-success" style="width: 15px;height: 15px" role="status">
                <span class="visually-hidden">Loading...</span>
            </div>`

        const body = {accountId,questions,answer}
        fetch("/forgot/password",{
            method: "POST",
            body: JSON.stringify(body),
            headers: {
                'Content-Type': 'application/json',
            }
        }).then(async res => {
            return {data:await res.json(), status: res.status}
        }).then(result => {
            if (result.status === 200) {
                document.querySelector("#passwordResult").innerHTML = `<p class="text-muted mt-3">${result.data.tempPassword}</p>`
            } else {
                document.querySelector("#passwordResult").innerHTML = `<p class="text-danger mt-3">${result.data.message}</p>`
            }
        }).finally(() => {
            evt.target.disabled = false
            evt.target.innerHTML = innerHtml
        })
    } else {
        alert("한개 이상의 값이 비어있습니다")
    }
})