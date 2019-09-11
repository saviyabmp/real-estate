FROM gitpod/workspace-full

USER root

RUN apt update
RUN yes | apt install snapd
RUN yes | snap install --classic heroku
