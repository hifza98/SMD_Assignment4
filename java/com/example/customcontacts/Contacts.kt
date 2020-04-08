package com.example.customcontacts

import java.io.Serializable;

data class Contacts(var firstname: String, var lastname: String, var cnumber: String, var cemail: String): Serializable  {
}