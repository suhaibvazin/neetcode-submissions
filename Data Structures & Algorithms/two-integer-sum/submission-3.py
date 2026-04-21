class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        diffMap= {}
        i=0
        for i in range(len(nums)):
            if nums[i] in diffMap:
                return [diffMap.get(nums[i]),i]
            diffMap[target-nums[i]]=i
            
            
        