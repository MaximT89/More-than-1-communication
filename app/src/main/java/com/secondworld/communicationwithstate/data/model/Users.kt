package com.secondworld.communicationwithstate.data.model

interface Users {

    class Manager(val name : String) : Users

    class Admin(val name : String) : Users

    class ProductManager(val name : String) : Users

    class Designer(val name : String) : Users
}