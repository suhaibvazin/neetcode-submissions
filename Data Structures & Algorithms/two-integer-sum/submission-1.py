class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        sumMap= {}
        i=0
        for i in range(len(nums)):
            if nums[i] in sumMap:
                return [sumMap.get(nums[i]),i]
            sumMap[target-nums[i]]=i
            
            
        