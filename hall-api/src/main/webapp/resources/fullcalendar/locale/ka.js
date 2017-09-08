!function (e) {
    "function" == typeof define && define.amd ? define(["jquery", "moment"], e) : "object" == typeof exports ? module.exports = e(require("jquery"), require("moment")) : e(jQuery, moment)
}(function (e, a) {
    !function () {
        var e = a.defineLocale("ka", {
            months: "იანვარი_თებერვალი_მარტი_აპრილი_მაისი_ივნისი_ივლისი_აგვისტო_სექტემბერი_ოქტომბერი_ნოემბერი_დეკემბერი".split("_"),
            monthsShort: "იან_თებ_მარ_აპრ_მაი_ივნ_ივლ_აგვ_სექტ_ოქტ_ნოემბ_დეკ".split("_"),
            weekdays: "კვირა_ორშაბათი_სამშაბათი_ოთხშაბათი_ხუთშაბათ_პარასკევი_შაბათი".split("_"),
            weekdaysShort: "კვ_ორშ_სამშ_ოთხშ_ხუთშ_პარ_შაბ".split("_"),
            weekdaysMin: "კვ_ორ_სა_ოთ_ხუ_პა_შა".split("_"),
            longDateFormat: {
                LT: "h:mm A",
                LTS: "h:mm:ss A",
                L: "DD/MM/YYYY",
                LL: "D MMMM YYYY",
                LLL: "D MMMM YYYY h:mm A",
                LLLL: "dddd, D MMMM YYYY h:mm A"
            },
            calendar: {
                sameDay: "[Today at] LT",
                nextDay: "[Tomorrow at] LT",
                nextWeek: "dddd [at] LT",
                lastDay: "[Yesterday at] LT",
                lastWeek: "[Last] dddd [at] LT",
                sameElse: "L"
            },
            relativeTime: {
                future: "in %s",
                past: "%s ago",
                s: "a few seconds",
                m: "a minute",
                mm: "%d minutes",
                h: "an hour",
                hh: "%d hours",
                d: "a day",
                dd: "%d days",
                M: "a month",
                MM: "%d months",
                y: "a year",
                yy: "%d years"
            },
            ordinalParse: /\d{1,2}(st|nd|rd|th)/,
            ordinal: function (e) {
                var a = e % 10, r = 1 === ~~(e % 100 / 10) ? "th" : 1 === a ? "st" : 2 === a ? "nd" : 3 === a ? "rd" : "th";
                return e + r
            },
            week: {dow: 1, doy: 4}
        });
        return e
    }(), e.fullCalendar.datepickerLocale("en-au", "en-AU", {
        closeText: "Done",
        prevText: "წინა",
        nextText: "შემდეგი",
        currentText: "დღეს",
        monthNames: ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"],
        monthNamesShort: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
        dayNames: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"],
        dayNamesShort: ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"],
        dayNamesMin: ["Su", "Mo", "Tu", "We", "Th", "Fr", "Sa"],
        weekHeader: "კვ",
        dateFormat: "dd/mm/yy",
        firstDay: 1,
        isRTL: !1,
        showMonthAfterYear: !1,
        yearSuffix: ""
    }), e.fullCalendar.locale("ka",{
        buttonText: {month: "თვე", week: "კვირა", day: "დღე", list: "შეხვედრების სია",today: "დღეს"},
        allDayText: "მთელი დღე",
        eventLimitText: function (e) {
            return "+ კიდევ " + e
        },
        noEventsMessage: "შეხვედრები არ არის"
    })
});