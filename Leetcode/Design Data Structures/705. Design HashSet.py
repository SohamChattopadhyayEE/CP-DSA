class MyHashSet:
    
    def __init__(self):
        self.lis = []
        

    def add(self, key: int) -> None:
        if not self.contains(key):
            self.lis.append(key)
        

    def remove(self, key: int) -> None:
        if self.contains(key):
            self.lis.remove(key)
        

    def contains(self, key: int) -> bool:
        def binarySearch(key):
            l=0
            h=len(self.lis)-1
            while l<=h:
                mid = int(l+(h-l)/2)
                if self.lis[mid]==key:
                    return True
                if self.lis[mid]<key:
                    l = mid+1
                elif self.lis[mid]>key:
                    h = mid-1
            return False
        self.lis.sort()
        return binarySearch(key)
