class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        diffMap= {}
        i=0
        for i,n in enumerate(nums):
            if n in diffMap:
                return [diffMap[n],i]
            diffMap[target-n]=i
            
            
        