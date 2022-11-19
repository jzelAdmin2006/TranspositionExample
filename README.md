# M114 Codebeispiel Verschlüsselung mit Transposition

#### BBZW Sursee Modul 114, Codebeispiel Verschlüsselung und Entschlüsselung mit Transposition: Zaun- und Matrixmethode
geschrieben von Johannes Zeller

Empfohlene Java-Version: 17.0.5


Download Jar: https://drive.google.com/uc?id=105AQlf9VF4_VTlDSaD-cjfTg-H27JzT-&export=download

Download Exe: https://drive.google.com/uc?id=10-YcFYWpKwDLrTdf9FSKWaCxjLmNr6z-&export=download&confirm=t&uuid=b1460e86-b429-413f-a24d-cdfd41732d01


## Befehle
- /encrypt {encryptionMethod} {encryptionKey} {stringToEncrypt}
- /decrypt {encryptionMethod} {decryptionKey} {stringToDecrypt}
- /exit

## Beispiel Verschlüsselung Zaunmethode
- Input = "/encrypt FenceCryptography 20 Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
- Output = "Lroaou prn rtam gaeedeialmtitnmi cp c qieidieupssodrasncmio.uoisdlmcnuuo  gindd, et ote  tleloueomidt rat  e  ,dlrst eaoisb"

## Beispiel Entschlüsselung Zaunmethode
- Input = "/decrypt FenceCryptography 20 Lroaou prn rtam gaeedeialmtitnmi cp c qieidieupssodrasncmio.uoisdlmcnuuo  gindd, et ote  tleloueomidt rat  e  ,dlrst eaoisb"
- Output = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."

## Beispiel Verschlüsselung Matrixmethode
- Input = "/encrypt MatrixTransposition 76134205 LoremIpsumDolorSitAmet,ConsecteturAdipiscingElit,SedDoEiusmodTemporIncididuntUtLaboreEtDoloreMagnaAliqua."
- Output = "pr,eiiEeittau rDAsAnemruooA IottploTcUEMq eomedgdoInrrl mleciEDdnteei sSCtstimdLDga omtnriSsodbla Luiouc,upiaon."

## Beispiel Entschlüsselung Matrixmethode
- Input = "/decrypt MatrixTransposition 76134205 pr,eiiEeittau rDAsAnemruooA IottploTcUEMq eomedgdoInrrl mleciEDdnteei sSCtstimdLDga omtnriSsodbla Luiouc,upiaon."
- Output = "LoremIpsumDolorSitAmet,ConsecteturAdipiscingElit,SedDoEiusmodTemporIncididuntUtLaboreEtDoloreMagnaAliqua."
