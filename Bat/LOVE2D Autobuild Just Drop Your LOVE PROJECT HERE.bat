echo off

if exist %1\main.lua (
 "%ProgramFiles%\WinRAR\WinRAR.exe" a -afzip -m5 -ed -r -ep1 %UserProfile%\Desktop\%~n1.love "%UserProfile%\Desktop\%~n1\"
 cd %ProgramFiles%\LOVE
 copy /b love.exe + %UserProfile%\Desktop\%~n1.love "%~n1.exe"
 del %UserProfile%\Desktop\%~n1.love
 mkdir "%UserProfile%\Desktop\game"
 xcopy /s *.dll %UserProfile%\Desktop\game
 xcopy /s license.txt C:\Users\%username%\Desktop\game
 move %~n1.exe %UserProfile%\Desktop\game
) else (
 echo "main.lua" not found in "%~n1" or no love2d project folder dropped
 pause
)