package com.artemisSoftware

import com.artemisSoftware.meetings.Location
import com.artemisSoftware.meetings.PostalCode
import com.artemisSoftware.meetings.UKPostCode
import com.artemisSoftware.meetings.USZipCode


abstract class PostalAddress(val firstLine: String,
                             val secondLine: String,
                             val city: String,
                             val county: String,
                             val postCode: PostalCode
) : Location()

class UkAddress(firstLine: String,
                secondLine: String,
                city: String,
                county: String,
                postCode: UKPostCode
) : PostalAddress(firstLine, secondLine, city, county, postCode)

class UsAddress(firstLine: String,
                secondLine: String,
                city: String,
                county: String,
                zipCode: USZipCode
) : PostalAddress(firstLine, secondLine, city, county, zipCode)