/*
 * Copyright 2007 Marc Kramis
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * $Id: IPhase.java 2498 2007-03-05 12:32:43Z lemke $
 * 
 */

package org.jscsi.connection;

import java.nio.ByteBuffer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jscsi.parser.login.LoginStage;

/**
 * A State Pattern. Each phase of the iSCSI Protocol must implement this
 * interface.
 * 
 * @author Volker Wildi
 */
interface IPhase {

  // --------------------------------------------------------------------------
  // --------------------------------------------------------------------------

  /**
   * This method handles the login of a connection (if possible).
   * 
   * @param session
   *          The context object of the current session.
   * @throws Exception
   *           if any error occurs.
   */
  public void login(final Session session) throws Exception;

  /**
   * This method handles the logout of a connection (if possible) (if possible
   * in the current phase).
   * 
   * @param session
   *          The context object of the current session.
   * @param connectionID
   *          The ID of the connection to close.
   * @throws Exception
   *           if any error occurs.
   */
  public void logoutConnection(final Session session, final short connectionID)
      throws Exception;

  /**
   * This method handles the logout of the whole session (with all its
   * connections) (if possible in the current phase).
   * 
   * @param session
   *          The context object of the current session.
   * @throws Exception
   *           if any error occurs.
   */
  public void logoutSession(final Session session) throws Exception;

  /**
   * This method handles a read operation within this session (if possible in
   * the current phase).
   * 
   * @param session
   *          The context object of the current session.
   * @param dst
   *          The buffer to store the read data.
   * @param logicalBlockAddress
   *          The logical block address to start the read operation.
   * @param length
   *          The number of bytes to read.
   * @throws Exception
   *           if any error occurs.
   */
  public void read(final Session session, final ByteBuffer dst,
      final int logicalBlockAddress, final long length) throws Exception;

  /**
   * This method handles a write operation within this session (if possible in
   * the current phase).
   * 
   * @param session
   *          The context object of the current session.
   * @param src
   *          Write the remaining bytes to the iSCSI Target.
   * @param logicalBlockAddress
   *          The logical block address to start the write operation.
   * @param length
   *          The number of bytes to write.
   * @throws Exception
   *           if any error occurs.
   */
  public void write(final Session session, final ByteBuffer src,
      final int logicalBlockAddress, final long length) throws Exception;

  /**
   * This method handles the <code>TargetCapacityInformations</code> within
   * this session (if possible in the current phase).
   * 
   * @param session
   *          The context object of the current session.
   * @param capacityInformation
   *          A <code>TargetCapacityInformations</code> instance to store
   *          these informations.
   * @throws Exception
   *           if any error occurs.
   */
  public void getCapacity(final Session session,
      final TargetCapacityInformations capacityInformation) throws Exception;

  /**
   * Returns the current stage.
   * 
   * @return The current stage.
   * @see LoginStage
   */
  public LoginStage getStage();

  // --------------------------------------------------------------------------
  // --------------------------------------------------------------------------
  // --------------------------------------------------------------------------
  // --------------------------------------------------------------------------
}

/**
 * This abstract class contains the basic implementation of a phase. Each method
 * should throw an <code>UnsupportedOperationException</code> to indicate
 * incomplete behavior.
 * 
 * @author Volker Wildi
 */
abstract class AbstractPhase implements IPhase {

  // --------------------------------------------------------------------------
  // --------------------------------------------------------------------------

  /** The Logger interface. */
  protected static final Log LOGGER = LogFactory.getLog(AbstractPhase.class);

  // --------------------------------------------------------------------------
  // --------------------------------------------------------------------------

  /**
   * Default constructor to create a new, empty <code>AbstractPhase</code>
   * object.
   */
  protected AbstractPhase() {

  }

  // --------------------------------------------------------------------------
  // --------------------------------------------------------------------------

  /** {@inheritDoc} */
  public void login(final Session session) throws Exception {

    throw new UnsupportedOperationException(
        "This operation is not possible in the current phase.");
  }

  /** {@inheritDoc} */
  public void logoutConnection(final Session session, final short connectionID)
      throws Exception {

    throw new UnsupportedOperationException(
        "This operation is not possible in the current phase.");
  }

  /** {@inheritDoc} */
  public void logoutSession(final Session session) throws Exception {

    throw new UnsupportedOperationException(
        "This operation is not possible in the current phase.");
  }

  /** {@inheritDoc} */
  public void read(final Session session, final ByteBuffer dst,
      final int logicalBlockAddress, final long length) throws Exception {

    throw new UnsupportedOperationException(
        "This operation is not possible in the current phase.");

  }

  /** {@inheritDoc} */
  public void write(final Session session, final ByteBuffer src,
      final int logicalBlockAddress, final long length) throws Exception {

    throw new UnsupportedOperationException(
        "This operation is not possible in the current phase.");
  }

  /** {@inheritDoc} */
  public void getCapacity(final Session session,
      final TargetCapacityInformations capacityInformation) throws Exception {

    throw new UnsupportedOperationException(
        "This operation is not possible in the current phase.");
  }

  // --------------------------------------------------------------------------
  // --------------------------------------------------------------------------

  /** {@inheritDoc} */
  public LoginStage getStage() {

    throw new UnsupportedOperationException();
  }

  // --------------------------------------------------------------------------
  // --------------------------------------------------------------------------
  // --------------------------------------------------------------------------
  // --------------------------------------------------------------------------
}
