package utils.date

import utils.jsToKotlin.JsDate
import utils.string.padWithZero

/**
 * @author x4fyr
 * Created on 1/18/17.
 */
class DateOnly(year: Int, month: Int, dayOfMonth: Int) : Comparable<DateOnly> {
    val jsDate: JsDate = JsDate(year, month, dayOfMonth)

    fun at(time: Time): DateTime = DateTime(year = getYear(), month = getMonth(), dayOfMonth = getDayOfMonth(),
            hours = time.getHours(), minutes = time.getMinutes(), seconds = time.getSeconds(),
            milliseconds = time.getMillis())

    fun atStartOfDay(): DateTime = at(Time.MIN)
    fun atEndOfDay(): DateTime = at(Time.MAX)

    override fun toString(): String {
        val year = padWithZero(getYear(), 4)
        val month = padWithZero(getMonth(), 2)
        val day = padWithZero(getDayOfMonth(), 2)
        return "$year-$month-$day"
    }
    override fun compareTo(other: DateOnly): Int = getEpochMillis() - other.getEpochMillis()
    override fun equals(other: Any?): Boolean = other is DateOnly && getEpochMillis() == other.getEpochMillis()
    override fun hashCode(): Int = getEpochMillis()

    fun getYear(): Int = jsDate.getFullYear()
    fun getMonth(): Int = jsDate.getMonth()
    fun getDayOfMonth(): Int = jsDate.getDate()
    fun getEpochMillis(): Int = jsDate.getTime()
}