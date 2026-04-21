class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        dupSet = set();
        for ele in nums:
            if ele in dupSet:
                return True
            else:
                dupSet.add(ele)
        return False

        