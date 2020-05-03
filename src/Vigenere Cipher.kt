import kotlin.system.exitProcess

fun getKey(text: String, vkey:String): String
{
    var varkey: String
    if(text.length==vkey.length){
        varkey=vkey
    }
    else
    {
        varkey = vkey
        for(ele in 0 until (text.length-vkey.length))
        {
            varkey += vkey[(ele%(vkey.length))]
        }
    }
    return varkey
}
 fun vencrypt(text: String, vkey: String): String {

     var result = ""
     val key = getKey(text,vkey)
     for(i in 0 until text.length)
        {
            if(text[i].isUpperCase())
            {
                result += ((((text[i].toInt()+key[i].toInt())%26)+'A'.toInt()).toChar().toString())
            }
            else if(text[i].isLowerCase())
            {
                result += ((((text[i].toInt()+key[i].toInt())%26)+'a'.toInt()).toChar().toString())
            }
            else
            {
                result += text[i]
            }
        }
    return result
}

fun vdecrypt(text: String, vkey: String): String {
    var result = ""
    val key = getKey(text,vkey)
    for(i in 0 until text.length)
    {
        if(text[i].isUpperCase())
        {
            result += ((((text[i].toInt()-key[i].toInt()+26)%26)+'A'.toInt()).toChar().toString())
        }
        else if(text[i].isLowerCase())
        {
            result += ((((text[i].toInt()-key[i].toInt()+26)%26)+'a'.toInt()).toChar().toString())
        }
        else
        {
            result += text[i]
        }
    }
    return result
}

fun vmenu(): Int{
    println("\t\t\t**** Vigenere Cipher ****\t\t\t\n"+"MENU:\n"+"1) Encrypt\n"+"2) Decrypt\n"+"3) Exit\n")
    println("Enter your choice here: \t")
    val option = readLine()!!.toInt(); if (option==3) {println("Thank You!");exitProcess(0)}

    println("Enter the text here: ")
    val usrInput = readLine()!!

    println("Enter the secret key: ")
    val vkey = readLine()!!

    when(option)
    {
        1 -> print("Your encrypted message is: "+ vencrypt(usrInput,vkey)+"\n")
        2 -> print("Your decrypted message is: "+vdecrypt(usrInput,vkey)+"\n")
        else -> "Invalid Choice!\n"
    }
    return 0
}

fun main(){

    while(true){ vmenu()}

}

