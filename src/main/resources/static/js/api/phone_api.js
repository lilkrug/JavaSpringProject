async function deletePhoneByNameA(data, token) {
    return await fetch("/admin/deletePhoneByNameA", {
        method: 'DELETE',
        headers: {
            'Authorization': `Bearer ${token}`,
            'content-type': 'application/json'
        },
        body: JSON.stringify(data)

    });
}
async function deletePhoneByNameU(data, token) {
    return await fetch("/user/deletePhoneByNameU", {
        method: 'DELETE',
        headers: {
            'Authorization': `Bearer ${token}`,
            'content-type': 'application/json'
        },
        body: JSON.stringify(data)

    });
}

async function updatePhone(data, token) {
    return await fetch("/admin/updatePhone", {
        method: 'PUT',
        headers: {
            'Authorization': `Bearer ${token}`,
            'content-type': 'application/json'
        },
        body: JSON.stringify(data)

    });
}

async function userGetPhoneByName(name, token) {
    return await fetch(`/user/userGetPhoneByName/${name}`, {
        method: 'GET',
        headers: {
            'Authorization': `Bearer ${token}`,
            'content-type': 'application/json'
        }

    }).then(function (res) {
        return res.json();
    }).then(function (data) {
        return data;
    });
}

async function adminGetPhoneByName(name, token) {
    return await fetch(`/admin/adminGetPhoneByName/${name}`, {
        method: 'GET',
        headers: {
            'Authorization': `Bearer ${token}`,
            'content-type': 'application/json'
        }

    }).then(function (res) {
        return res.json();
    }).then(function (data) {
        return data;
    });
}
async function isPhoneExistByName(data, token) {
    return await fetch("/admin/isPhoneExistByName",{
        method :'POST',
        headers: {
            'Authorization': `Bearer ${token}`,
            'content-type': 'application/json'
        },
        body:JSON.stringify(data)

    });
}
async function createPhone(data, token) {
    return await fetch("/admin/createPhone",{
        method :'POST',
        headers: {
            'Authorization': `Bearer ${token}`,
            'content-type': 'application/json'
        },
        body:JSON.stringify(data)

    });
}
async function getAllPhonesForAdmin(token) {
    return await fetch(`/admin/getAllPhonesForAdmin`, {
        method: "GET",
        headers: {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${token}`,
        }
    }).then(function (res) {
        return res.json();
    }).then(function (data) {
        return data;
    });
}
async function getAllPhonesForUser(token) {
    return await fetch(`/user/getAllPhonesForUser`, {
        method: "GET",
        headers: {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${token}`,
        }
    }).then(function (res) {
        return res.json();
    }).then(function (data) {
        return data;
    });
}