##二分查找总结

###指针
1. 如果需要指针最后停留在一个元素 while(lo<hi)
2. 如果需要指针最后停留在相邻的两个元素 while(lo+1<hi)
3. 如果允许两个指针跨越 while(lo<=hi)
4. 找区间左端点 if(target > nums[mid]) lo = mid + 1 else hi = mid;
5. 找区间右端点 if(target < nums[mid]) hi = mid - 1 else lo = mid; 
*注意：查找右端点存在lo = mid，可能会导致死循环。需要使用while(lo+1 < hi)*