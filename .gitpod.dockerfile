FROM gitpod/workspace-full

USER root

RUN yes | apt install snapd
RUN yes | snap install --classic heroku