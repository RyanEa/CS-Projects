#ifndef __DATE_H
#define __DATE_H
#include <iostream>
class Date {
private:
   int mMonth, mDay, mYear;
public:
   Date(const int &month, const int &day, const int &year);
   void DisplayDate();
   const int &GetMonth() const;
   const int &GetDay() const;
   const int &GetYear() const;
   void SetMonth(const int &month);
   void SetDay(const int &day);
   void SetYear(const int &year);
};
#endif