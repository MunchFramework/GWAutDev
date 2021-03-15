Set olApp = CreateObject("Outlook.Application")
Set olNs = olApp.GetNamespace("MAPI")
'Below ScenarioType is the argument passing through the java code while running the Vba file.
ScenarioType=WScript.Arguments.Item(1)

If(ScenarioType="Declined") Then

'Below SubId is the argument passing while running the Vba file.
SubId="Private Company Declined - Submission #"&WScript.Arguments.Item(0)

Else
SubId="Private Company Referral - Submission #"&WScript.Arguments.Item(0)
End If
Set FolderSelected = olNs.GetDefaultFolder(6)


'Below code is to read the content of the mail body
mailcontent=""
For Each itm In FolderSelected.Items
 If InStr(itm.subject,SubId)>0 then
      subject=Cstr(itm.subject)
     mailcontent=Cstr(itm.body)
  data=Split(mailcontent,vbNewLine)


'Below code is to read the write of the mail body to existing EmailContent.txt file
  Set fs = CreateObject("Scripting.FileSystemObject")
  Set objFileToWrite = fs.OpenTextFile("C:\Selenium\Projects\Automation_Insureon_V3\resources\PayLoads\EmailContent.txt",2,true)
   for i=LBound(data) to UBound(data)
     objFileToWrite.WriteLine(data(i))
   Next
  objFileToWrite.Close
  Set objFileToWrite = Nothing
 end if
Next