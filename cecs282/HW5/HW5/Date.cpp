#include "Date.h"
using namespace std;
void Date::DisplayDate() {
   cout << mMonth << "/" << mDay << "/" << mYear << endl;
}
Date::Date(const int &month, const int &day, const int &year)
   : mMonth(month), mDay(day), mYear(year) {
   if (month >= 1 && month <= 12) {
      mMonth = month;
   }
   else {
      mMonth = 1;
   }
}
void Date::SetMonth(const int &month) {
   if (month >= 1 && month <= 12) {
      mMonth = month;
   }
   else {
      mMonth = 1;
   }
}
void Date::SetDay(const int &day) {
   mDay = day;
}
void Date::SetYear(const int &year) {
   mYear = year;
}
const int &Date::GetMonth() const {
   return mMonth;
}
const int &Date::GetDay() const {
   return mDay;
}
const int &Date::GetYear() const {
   return mYear;
}