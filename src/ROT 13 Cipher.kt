import kotlin.system.exitProcess

fun rotEncrypt(text: String): String {

    var result = ""
    val key = 13
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


fun rotMenu(): Int{
    println("\t\t\t**** ROT 13 Cipher ****\t\t\t\n"+"MENU:\n"+"1) Encrypt\n"+"2) Decrypt\n"+"3) Exit\n")
    println("Enter your choice here: \t")
    val option = readLine()!!.toInt(); if (option==3) {println("Thank You!");exitProcess(0)}

    println("Enter the text here: ")
    val usrInput = readLine()!!

    when(option)
    {
        1 -> print("Your encrypted message is: "+ rotEncrypt(usrInput)+"\n")
        /**2 -> print("Your decrypted message is: "+rotdecrypt(usrInput)+"\n")**/
        else -> "Invalid Choice!\n"
    }
    return 0
}

fun main(){

    while(true){rotMenu()}

}

