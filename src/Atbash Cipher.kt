import kotlin.system.exitProcess

fun atEncrypt(text:String): String {
    var result = ""
    val capitalAlpha = mutableListOf<Char>()
    for(c in 'A'..'Z'){
        capitalAlpha.add(c)
    }

    val lowerAlpha = mutableListOf<Char>()
    for(c in capitalAlpha){
        lowerAlpha.add(c.toLowerCase())
    }

    for(i in text.indices){
        result += when {
            text[i].isUpperCase() -> {
                capitalAlpha.reversed()[capitalAlpha.indexOf(text[i])]
            }
            text[i].isLowerCase() -> {
                lowerAlpha.reversed()[lowerAlpha.indexOf(text[i])]
            }
            else -> {
                text[i]
            }
        }
    }
    return result
}

fun atDecrypt(text:String): String {
    var result = ""

    val capitalAlpha = mutableListOf<Char>()
    for(c in 'A'..'Z'){
        capitalAlpha.add(c)
    }

    val lowerAlpha = mutableListOf<Char>()
    for(c in capitalAlpha){
        lowerAlpha.add(c.toLowerCase())
    }

    for(i in text.indices){
        result += when {
            text[i].isUpperCase() -> {
                capitalAlpha[capitalAlpha.reversed().indexOf(text[i])]
            }
            text[i].isLowerCase() -> {
                lowerAlpha[lowerAlpha.reversed().indexOf(text[i])]
            }
            else -> {
                text[i]
            }
        }
    }
    return result
}

fun atMenu(): Int{
    println("\n\t\t\t**** Atbash Cipher ****\t\t\t\n"+"MENU:\n"+"1) Encrypt\n"+"2) Decrypt\n"+"3) Exit\n")
    println("Enter your choice here: \t")
    val option = readLine()!!.toInt(); if (option==3) {println("Thank You!");exitProcess(0)}

    println("Enter the text here: ")
    val usrInput = readLine()!!

    when(option)
    {
        1 -> print("Your encrypted message is: "+ atEncrypt(usrInput)+"\n")
        2 -> print("Your decrypted message is: "+atDecrypt(usrInput)+"\n")
    }
    return 0
}

fun main(){

    while(true){atMenu()}
}

