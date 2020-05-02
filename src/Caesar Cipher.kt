import kotlin.system.exitProcess

fun encrypt(text: String, key: Int): String {

    var result = ""
    for (element in text.toCharArray(startIndex = 0, endIndex = text.length))
    {
        result += if(element.isUpperCase()) {
            ((((element.toInt() + key - 65) % 26) + 65).toChar()).toString()
        } else if (element.isLowerCase()) {
            ((((element.toInt() + key - 97) % 26) + 97).toChar()).toString()
        } else {
            (element.toString())
        }
    }
    return result
}

fun decrypt(text: String, key: Int): String {
    var result = ""
    for (element in text.toCharArray(startIndex = 0, endIndex = text.length))
    {
        if(element.isUpperCase())
        {
            result += if(element.toInt()-key>='A'.toInt() && element.toInt()-key<='Z'.toInt()) {
                 ((element.toInt() - key).toChar().toString())
            } else {
                 (((element.toInt() - key) + 'Z'.toInt() - 'A'.toInt() + 1).toChar().toString())
            }
        }
        else if (element.isLowerCase())
        {
            result += if(element.toInt()-key>='a'.toInt() && element.toInt()-key <= 'z'.toInt()) {
                 ((element.toInt() - key).toChar().toString())
            } else {
                 (((element.toInt() - key)+'z'.toInt()-'a'.toInt()+1).toChar().toString())
            }
        }
        else
        {
            result += (element.toString())
        }
    }
    return result
}

fun menu(): Int{
    println("\t\t\t**** Caesar Cipher ****\t\t\t\n"+"MENU:\n"+"1) Encrypt\n"+"2) Decrypt\n"+"3) Exit\n")
    println("Enter your choice here: \t")
    val option = readLine()!!.toInt(); if (option==3) {println("Thank You!");exitProcess(0)}

    println("Enter the text here: ")
    val usrInput = readLine()!!

    println("Enter the secret key: ")
    val key = readLine()!!.toInt()

    when(option)
    {
        1 -> print("Your encrypted message is: "+ encrypt(usrInput,key)+"\n")
        2 -> print("Your decrypted message is: "+decrypt(usrInput,key)+"\n")
        else -> "Invalid Choice!\n"
    }
    return 0
}

fun main(){

    while(true){ menu()}

}

