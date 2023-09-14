import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Calendar

fun main() {


    //Dates of Full Moons
    val fullmoons = arrayOf("01/6/2023", "02,05,2023", "03/07/2023", "04/06/2023", "05/05/2023", "06/03/2023", "07/03/2023", "08/01/2023", "08/30/2023", "09/29/2023", "10/28/2023", "11/17/2023", "12/26/2023")


    //date formatter to handle dates
    val dateFormatter = DateTimeFormatter.ofPattern("MM-dd-YYYY")


    //get the current day
    val today = LocalDateTime.now()
    //reformat totday to a more usable format
    val fToday = today.format(dateFormatter)

    //store values for todays current month and current year, so testing on these values will be easier
    val currMonth = fToday.subSequence(0..1)
    val currYear = fToday.subSequence(6,10)
    val currDay = fToday.subSequence(3,5)


    //determine the next Full moon
    //fm = full Moon
    var iterationID = 0
    for (fm in fullmoons){
        val moonMonth = fm.subSequence(0..1)
        val moonDay = fm.subSequence(3,5)
        //fme = full moon expanded
        val fme = "$fm "
        val moonYear = fme.subSequence(6,10)
        println("$fm\n $moonMonth $moonDay $moonYear")

        if (currMonth.toString() == moonMonth.toString() && currYear.toString() == moonYear.toString()){
            //once month and year are the same, we know this entry is the next full moon, and its ID - 1 is the last full moon

            //determine the next full moon
            var dayCount:Int = currDay.toString().toInt()
            do{
                dayCount ++
            }while(dayCount.toString() != moonDay.toString())

            if (dayCount.toString() == moonDay.toString()){
                //this is the next full moon

                val lastMoonID = iterationID - 1


                //final Output of the moon Info
                println("The Next Full Moon Will be on: $fm, The Most Recent Full moon was ${fullmoons[lastMoonID]}")
                break

            }

        }
        iterationID++



    }









    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("")
}