package com.rsk

import Location

abstract class PostalAddress(val firstLine: String,
                             val secondLine: String,
                             val city: String,
                             val county: String,
                             val postCode: String) : Location()

class UkAddress(firstLine: String,
                secondLine: String,
                city: String,
                county: String,
                postCode: String) : PostalAddress(firstLine, secondLine, city, county, postCode)

class UsAddress(firstLine: String,
                secondLine: String,
                city: String,
                county: String,
                zipCode: String) : PostalAddress(firstLine, secondLine, city, county, zipCode)