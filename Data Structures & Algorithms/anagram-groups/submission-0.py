class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        angDict={}
        for angStr in strs:
            sortedAngStr=''.join(sorted(angStr))
            if sortedAngStr in angDict:
                tempList=angDict[sortedAngStr]
                tempList.append(angStr)
                angDict[sortedAngStr]=tempList
            else:
                angDict[sortedAngStr]=[angStr]
        
        return list(angDict.values())