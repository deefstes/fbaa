Copy-Item -Path "..\..\Proto\fbaa.proto" -Destination ".."
docker build -t fbaa-server -f Dockerfile ..
Remove-Item "..\fbaa.proto"
