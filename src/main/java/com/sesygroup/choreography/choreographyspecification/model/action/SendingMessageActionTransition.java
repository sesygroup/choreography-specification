/*
 * Copyright 2017 Software Engineering and Synthesis Group
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sesygroup.choreography.choreographyspecification.model.action;

import java.io.Serializable;

import com.sesygroup.choreography.choreographyspecification.model.Message;
import com.sesygroup.choreography.choreographyspecification.model.Participant;
import com.sesygroup.choreography.choreographyspecification.model.State;
import com.sesygroup.choreography.choreographyspecification.model.Transition;

/**
 *
 * @author Alexander Perucci (http://www.alexanderperucci.com/)
 *
 */
public class SendingMessageActionTransition extends Transition implements Serializable {
   private static final long serialVersionUID = -5373225098273224654L;
   private Message message;
   private Participant sourceParticipant;
   private Participant targetParticipant;

   public SendingMessageActionTransition() {
      super();
      message = null;
      sourceParticipant = null;
      targetParticipant = null;
   }

   public SendingMessageActionTransition(final State sourceState, final State targetState,
         final Participant sourceParticipant, final Participant targetParticipant, final Message message) {
      super(sourceState, targetState);
      this.message = message;
      this.sourceParticipant = sourceParticipant;
      this.targetParticipant = targetParticipant;
   }

   public Message getMessage() {
      return message;
   }

   public void setMessage(final Message message) {
      this.message = message;
   }

   public Participant getSourceParticipant() {
      return sourceParticipant;
   }

   public void setSourceParticipant(final Participant sourceParticipant) {
      this.sourceParticipant = sourceParticipant;
   }

   public Participant getTargetParticipant() {
      return targetParticipant;
   }

   public void setTargetParticipant(final Participant targetParticipant) {
      this.targetParticipant = targetParticipant;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((message == null)
            ? 0
            : message.hashCode());
      result = prime * result + ((super.sourceState == null)
            ? 0
            : super.sourceState.hashCode());
      result = prime * result + ((super.targetState == null)
            ? 0
            : super.targetState.hashCode());
      result = prime * result + ((sourceParticipant == null)
            ? 0
            : sourceParticipant.hashCode());
      result = prime * result + ((targetParticipant == null)
            ? 0
            : targetParticipant.hashCode());
      return result;
   }

   @Override
   public boolean equals(final Object obj) {
      if (this == obj) {
         return true;
      }
      if (obj == null) {
         return false;
      }
      if (getClass() != obj.getClass()) {
         return false;
      }
      SendingMessageActionTransition other = (SendingMessageActionTransition) obj;
      if (message == null) {
         if (other.message != null) {
            return false;
         }
      } else if (!message.equals(other.message)) {
         return false;
      }
      if (super.sourceState == null) {
         if (other.sourceState != null) {
            return false;
         }
      } else if (!super.sourceState.equals(other.sourceState)) {
         return false;
      }
      if (super.targetState == null) {
         if (other.targetState != null) {
            return false;
         }
      } else if (!super.targetState.equals(other.targetState)) {
         return false;
      }
      if (sourceParticipant == null) {
         if (other.sourceParticipant != null) {
            return false;
         }
      } else if (!sourceParticipant.equals(other.sourceParticipant)) {
         return false;
      }
      if (targetParticipant == null) {
         if (other.targetParticipant != null) {
            return false;
         }
      } else if (!targetParticipant.equals(other.targetParticipant)) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "(" + sourceState + ", " + sourceParticipant + ", " + message.getName() + ", " + targetParticipant + ", "
            + targetState + ")";
   }
}
