/*
Question: 
A k-booking happens when k events have some non-empty intersection (i.e., there is some time that is common to all k events.)
You are given some events [startTime, endTime), after each given event, return an integer k representing the maximum k-booking between all the previous events.
Implement the MyCalendarThree class:
MyCalendarThree() Initializes the object.
int book(int startTime, int endTime) Returns an integer k representing the largest integer such that there exists a k-booking in the calendar.
*/
class MyCalendarThree {
    Map<Integer, Integer> map;
    public MyCalendarThree() {
        map = new TreeMap<>();
    }
    
    public int book(int startTime, int endTime) {
        map.put(startTime, map.getOrDefault(startTime, 0)+1);
        map.put(endTime, map.getOrDefault(endTime, 0)-1);
        int curr=0, res=0;
        for(int values: map.values()){
            curr += values;
            res = Math.max(res, curr);
        }
        return res;
    }
}
