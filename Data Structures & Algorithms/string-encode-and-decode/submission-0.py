class Solution:

    def encode(self, strs: List[str]) -> str:
        # Format: len#string
        return ''.join(f'{len(s)}#{s}' for s in strs)

    def decode(self, s: str) -> List[str]:
        result = []
        i = 0
        while i<len(s):
            idx=s.find('#',i)
            leng=int(s[i:idx])
            i=idx+1
            result.append(s[i:i+leng])
            i=i+leng
        return result
      