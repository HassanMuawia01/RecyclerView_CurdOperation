package com.example.recyclerviewactivity

class DataClass {
    var img: Int = 0
    var name: String
    var phone: String

    constructor(img: Int, name: String, phone: String) {
        this.img = img
        this.name = name
        this.phone = phone
    }

     constructor(name: String, phone: String) {
        this.name = name
        this.phone = phone
    }

}